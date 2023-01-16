package com.example.xmlexercise.domain.dtos.users;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Getter
@NoArgsConstructor
@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersImportDTO {

    @XmlElement(name = "user")
    private List<UserImportDTO> users;
}
