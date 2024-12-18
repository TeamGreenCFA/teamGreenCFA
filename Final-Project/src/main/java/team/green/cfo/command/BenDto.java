package team.green.cfo.command;

public class BenDto {

    private Integer id;

    /*@NotNull*/ (message = "First name is mandatory")
    /*@NotBlan*/ (message = "First name is mandatory")
    /*@Size*/ (min = 3, max = 64)
    private String firstName;

    /*@NotNull*/ (message = "First name is mandatory")
    /*@NotBlank*/ (message = "First name is mandatory")
    /*@Size*/ (min = 3, max = 64)
    private String lastName;

    /*
    @Email
    @NotBlank (message = "Email is mandatory")
    private String email;

     */

     
    /*@Pattern*/ (regexp = "^\\+?[0-9]*$", message = "Phone number contains invalid characters")
    /*@Size*/ (min = 9, max = 16)
    private String phone;
}
