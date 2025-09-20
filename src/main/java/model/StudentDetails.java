package model;

import lombok.*;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class StudentDetails {
    private int id;
    private String name;
    private String email;
    private String gender;
    private String course;
}
