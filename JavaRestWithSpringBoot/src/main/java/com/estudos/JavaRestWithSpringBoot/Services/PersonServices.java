package com.estudos.JavaRestWithSpringBoot.Services;

import com.estudos.JavaRestWithSpringBoot.Data.Vo.V1.PersonVO;
import com.estudos.JavaRestWithSpringBoot.Data.Vo.V2.PersonVOV2;
import com.estudos.JavaRestWithSpringBoot.Exceptions.ResourceNotFoundException;
import com.estudos.JavaRestWithSpringBoot.Mapper.Custom.PersonMapper;
import com.estudos.JavaRestWithSpringBoot.Mapper.DozerMapper;
import com.estudos.JavaRestWithSpringBoot.Models.Person;
import com.estudos.JavaRestWithSpringBoot.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.logging.Logger;

@Service
public class PersonServices {
    private final Logger logger = Logger.getLogger(PersonServices.class.getName());

    @Autowired
    PersonRepository repository;

    @Autowired
    PersonMapper mapper;

    public PersonVO findById(Long id) {
        logger.info("Finding one person!");

        var entity = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("No records found for this ID!"));

        return DozerMapper.parseObject(entity, PersonVO.class);
    }

    public List<PersonVO> findAll() {
        logger.info("Finding all people!");
        return DozerMapper.parseListObjects(repository.findAll(), PersonVO.class);
    }

    public PersonVO createPerson(PersonVO personVO) {
        logger.info("Creating one person");
        var entity = DozerMapper.parseObject(personVO, Person.class);
        return DozerMapper.parseObject(repository.save(entity), PersonVO.class);
    }

    public PersonVOV2 createPersonV2(PersonVOV2 personVO) {
        logger.info("Creating one person");
        var entity = mapper.convertVoToEntity(personVO);
        return mapper.convertEntityToVo(repository.save(entity));
    }

    public PersonVO updatePerson(PersonVO person) {
        logger.info("Updating one person with V2!");
        Person pFound = repository.findById(person.getId()).orElseThrow(() ->
                new ResourceNotFoundException("No records found for this ID!"));

        pFound.setFirstName(person.getFirstName());
        pFound.setLastName(person.getLastName());
        pFound.setAddress(person.getAddress());
        pFound.setGender(person.getGender());

        return DozerMapper.parseObject(repository.save(pFound), PersonVO.class);
    }

    public void deletePerson(Long id) {
        logger.info("Deleted one person:");
        var entity = repository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("No records found for this ID!"));;
        repository.deleteById(id);
    }
}
