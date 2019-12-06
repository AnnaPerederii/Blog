package ua.od.atomspace.Twitter.dao.models;


import lombok.*;

import javax.persistence.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private int age;

    private String email;

    private String username;

    private String password;

    private String createdAt;
}
