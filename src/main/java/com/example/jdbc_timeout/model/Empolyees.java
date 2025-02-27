package com.example.jdbc_timeout.model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table public.empolyees
 */
public class Empolyees implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.empolyees.id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.empolyees.age
     *
     * @mbg.generated
     */
    private Integer age;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.empolyees.date_created
     *
     * @mbg.generated
     */
    private LocalDateTime dateCreated;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.empolyees.first_name
     *
     * @mbg.generated
     */
    private String firstName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.empolyees.last_name
     *
     * @mbg.generated
     */
    private String lastName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column public.empolyees.last_updated
     *
     * @mbg.generated
     */
    private LocalDateTime lastUpdated;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table public.empolyees
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.empolyees.id
     *
     * @return the value of public.empolyees.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.empolyees.id
     *
     * @param id the value for public.empolyees.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.empolyees.age
     *
     * @return the value of public.empolyees.age
     *
     * @mbg.generated
     */
    public Integer getAge() {
        return age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.empolyees.age
     *
     * @param age the value for public.empolyees.age
     *
     * @mbg.generated
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.empolyees.date_created
     *
     * @return the value of public.empolyees.date_created
     *
     * @mbg.generated
     */
    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.empolyees.date_created
     *
     * @param dateCreated the value for public.empolyees.date_created
     *
     * @mbg.generated
     */
    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.empolyees.first_name
     *
     * @return the value of public.empolyees.first_name
     *
     * @mbg.generated
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.empolyees.first_name
     *
     * @param firstName the value for public.empolyees.first_name
     *
     * @mbg.generated
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.empolyees.last_name
     *
     * @return the value of public.empolyees.last_name
     *
     * @mbg.generated
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.empolyees.last_name
     *
     * @param lastName the value for public.empolyees.last_name
     *
     * @mbg.generated
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column public.empolyees.last_updated
     *
     * @return the value of public.empolyees.last_updated
     *
     * @mbg.generated
     */
    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column public.empolyees.last_updated
     *
     * @param lastUpdated the value for public.empolyees.last_updated
     *
     * @mbg.generated
     */
    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}