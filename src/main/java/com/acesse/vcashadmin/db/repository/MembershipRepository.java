package com.acesse.vcashadmin.db.repository;

import com.acesse.vcashadmin.db.entity.DboaspnetMembership;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Vadim_Korostelev on 6/2/2016.
 */
public interface MembershipRepository extends CrudRepository<DboaspnetMembership, String> {
}
