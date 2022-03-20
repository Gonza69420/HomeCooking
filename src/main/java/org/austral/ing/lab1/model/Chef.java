package org.austral.ing.lab1.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "USUARIOS") //creacion de tabla con el nombre usuario
public class Chef {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "ID_NUMBER", nullable = false, unique = true)
    private String idNumber;

    @Column(name = "ADDRESS", nullable = false)
    private String address;

    @Column(name = "EMAIL", nullable = false, unique = true)
    private String email;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "PHONE_NUMBER", unique = true)
    private String phoneNumber;

    @Column(name = "Estado")
    private Boolean estado;

    public Chef(){

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public static class ChefBuilder {
        private String firstName;
        private String lastName;
        private String idNumber;
        private String address;
        private String email;
        private String password;
        private String phoneNumber;


        public ChefBuilder(String email) {
            this.email = email;
        }

        public Chef.ChefBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Chef.ChefBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Chef.ChefBuilder idNumber(String idNumber) {
            this.idNumber = idNumber;
            return this;
        }

        public Chef.ChefBuilder address(String address) {
            this.address = address;
            return this;
        }

        public Chef.ChefBuilder password(String password) {
            this.password = password;
            return this;
        }

        public Chef.ChefBuilder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Chef build() {
            Chef user = new Chef();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setIdNumber(idNumber);
            user.setAddress(address);
            user.setEmail(email);
            user.setPassword(password);
            user.setPhoneNumber(phoneNumber);
            return user;
        } //commit

        private void Chef(Chef.ChefBuilder builder) {
            this.firstName = builder.firstName;
            this.lastName = builder.lastName;
            this.password = builder.password;
            this.email = builder.email;
            this.address = builder.address;
            this.idNumber = builder.idNumber;
            this.phoneNumber = builder.phoneNumber;

        }
    }
}
