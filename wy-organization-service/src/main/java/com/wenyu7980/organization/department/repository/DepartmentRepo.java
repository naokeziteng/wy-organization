package com.wenyu7980.organization.department.repository;

import com.wenyu7980.organization.department.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 *
 * @author wenyu
 */
@Repository
public interface DepartmentRepo
  extends JpaRepository<DepartmentEntity, String>, JpaSpecificationExecutor<DepartmentEntity> {
}
