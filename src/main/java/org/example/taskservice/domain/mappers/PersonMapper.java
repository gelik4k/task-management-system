package org.example.taskservice.domain.mappers;

import org.example.taskservice.domain.dto.PersonDto;
import org.example.taskservice.domain.dto.UserDto;
import org.example.taskservice.domain.models.Person;

public class PersonMapper {


    public static Person toEntity(PersonDto dto) {
        Person person = new Person();
        person.setEmail(dto.getEmail());
        return person;
    }

    public static PersonDto toDto(Person entity) {
        PersonDto personDto = new PersonDto();
        personDto.setEmail(entity.getEmail());
        return personDto;
    }


    public static Person toEntity(UserDto user){
      Person person= new Person();
      person.setUsername(user.getUsername());
      person.setEmail(user.getEmail());
      person.setPassword(user.getPassword());
      return person;
    }

}
