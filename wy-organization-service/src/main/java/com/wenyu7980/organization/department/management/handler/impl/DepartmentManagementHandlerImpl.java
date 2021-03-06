package com.wenyu7980.organization.department.management.handler.impl;

import com.wenyu7980.common.exceptions.code409.ExistedException;
import com.wenyu7980.common.exceptions.code409.InconsistentException;
import com.wenyu7980.organization.department.management.domain.DepartmentManagementAdd;
import com.wenyu7980.organization.department.management.domain.DepartmentManagementModify;
import com.wenyu7980.organization.department.management.handler.DepartmentManagementHandler;
import com.wenyu7980.organization.department.convert.DepartmentConvert;
import com.wenyu7980.organization.department.domain.Department;
import com.wenyu7980.organization.department.entity.DepartmentEntity;
import com.wenyu7980.organization.department.service.DepartmentQueryService;
import com.wenyu7980.organization.department.service.DepartmentService;
import com.wenyu7980.organization.user.entity.UserEntity;
import com.wenyu7980.organization.user.service.UserService;
import com.wenyu7980.query.QueryCompare;
import com.wenyu7980.query.QueryCondition;
import com.wenyu7980.query.QueryJoin;
import com.wenyu7980.query.QueryLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 *
 * @author wenyu
 */
@Component
public class DepartmentManagementHandlerImpl implements DepartmentManagementHandler {
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private UserService userService;
    @Autowired
    private DepartmentQueryService queryService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Department add(DepartmentManagementAdd department) {
        QueryLogic logic = QueryLogic.and(QueryCondition.of("deletedFlag", QueryCompare.EQ, false),
          QueryCondition.of("name", QueryCompare.EQ, department.getName()));
        if (Objects.nonNull(department.getParentId())) {
            logic = QueryLogic
              .and(logic, QueryJoin.join("parent", QueryCondition.of("id", QueryCompare.EQ, department.getLeaderId())));
        }
        if (queryService.exists(logic)) {
            throw new ExistedException("??????{0}?????????", department.getName());
        }
        UserEntity leader = Objects.nonNull(department.getLeaderId()) ?
          userService.findById(department.getLeaderId()) :
          null;

        DepartmentEntity parent = null;
        if (Objects.nonNull(department.getParentId())) {
            parent = departmentService.findById(department.getParentId());
            if (parent.getDeletedFlag()) {
                throw new InconsistentException("????????????{0}???????????????", parent.getName());
            }
        }
        DepartmentEntity entity = new DepartmentEntity(department.getName(), leader, parent);
        return DepartmentConvert.convert(departmentService.save(entity));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public Department modify(String id, DepartmentManagementModify department) {
        DepartmentEntity entity = departmentService.findById(id);
        QueryLogic logic = QueryLogic.and(QueryCondition.of("deletedFlag", QueryCompare.EQ, false),
          QueryCondition.of("name", QueryCompare.EQ, department.getName()));
        if (Objects.nonNull(department.getParentId())) {
            logic = QueryLogic
              .and(logic, QueryJoin.join("parent", QueryCondition.of("id", QueryCompare.EQ, department.getLeaderId())));
        }
        DepartmentEntity parent = null;
        if (Objects.nonNull(department.getParentId())) {
            parent = departmentService.findById(department.getParentId());
            if (parent.getDeletedFlag()) {
                throw new InconsistentException("????????????{0}???????????????", parent.getName());
            }
        }
        if (!Objects.equals(entity.getParent(), parent) && queryService.exists(logic)) {
            throw new ExistedException("??????{0}?????????", department.getName());
        }
        UserEntity leader = Objects.nonNull(department.getLeaderId()) ?
          userService.findById(department.getLeaderId()) :
          null;

        entity.modify(department.getName(), leader, department);
        return DepartmentConvert.convert(departmentService.save(entity));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void delete(String id) {
        DepartmentEntity entity = departmentService.findById(id);
        if (entity.getMembers().size() > 0) {
            throw new InconsistentException("????????????????????????");
        }
        if (entity.getDepartments().stream().filter(d -> !d.getDeletedFlag()).count() > 0) {
            throw new InconsistentException("??????????????????");
        }
        entity.delete();
        departmentService.save(entity);
    }
}
