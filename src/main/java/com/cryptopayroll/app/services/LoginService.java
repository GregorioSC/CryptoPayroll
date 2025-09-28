package com.cryptopayroll.app.services;

import com.cryptopayroll.app.DTOs.LoginDTO;
import com.cryptopayroll.app.domain.company.Company;
import com.cryptopayroll.app.domain.company.Manager;
import com.cryptopayroll.app.domain.employee.Employee;
import com.cryptopayroll.app.repositories.CompanyRepository;
import com.cryptopayroll.app.repositories.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


@Service
public class LoginService {



    private LoginDTO loginDTO;
    private ManagerRepository managerRepository;
    private CompanyRepository companyRepository;

    @Autowired
    private LoginService(LoginDTO loginDTO, ManagerRepository managerRepository, CompanyRepository companyRepository){
        this.loginDTO = loginDTO;
        this.managerRepository = managerRepository;
        this.companyRepository = companyRepository;
    }

    public Manager login(String email, String password){


        if (email.isEmpty()){
            throw new IllegalArgumentException("Can not have email empty");

        }

        if (password.isEmpty()){
            throw new IllegalArgumentException("Can not have password empty");

        }
        Manager man = managerRepository.findByEmail(email);

        if (man ==  null){
            throw new IllegalArgumentException("Wrong Login Information");
        }

        return man;
    }


    public Manager register( String companyName,String companyEmail, String companyPhone, String companyPassword){

        Company comp = new Company(companyName,companyEmail,companyPhone,companyPassword);

        companyRepository.save(comp);

        Manager manager = new Manager(companyName,companyEmail,companyPhone,companyPassword, comp);


        return manager;


    }
}
