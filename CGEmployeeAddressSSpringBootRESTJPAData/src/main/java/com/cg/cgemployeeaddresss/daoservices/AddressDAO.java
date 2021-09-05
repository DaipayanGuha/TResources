package com.cg.cgemployeeaddresss.daoservices;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.cgemployeeaddresss.beans.Address;

public interface AddressDAO  extends JpaRepository<Address, Integer>{

}
