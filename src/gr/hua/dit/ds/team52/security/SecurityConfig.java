package gr.hua.dit.ds.team52.security;

import gr.hua.dit.ds.team52.dao.ServiceDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //SERVICES AND THEIR ROLES
    private String[] CREATE_PETITION_ROLES={"STUDENT","ADMIN"};
    private String[] EXAMINE_PETITION_ROLES={"ADMIN","STAFF"};
    private String[] EXAMINE_INTERNSHIP_ROLES={"ADMIN","STAFF"};
    private String[] MANAGE_APPLICATION_ROLES={"ADMIN"};



    @Autowired
    private ServiceDAO serviceDAO;

    @Autowired
    DataSource myDataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        // add some dummy users for in memory authentication
//        auth.inMemoryAuthentication().withUser("john").password("{noop}test123").roles("STUDENT");        // "ROLE_" is automatically added
//        auth.inMemoryAuthentication().withUser("mary").password("{noop}test123").roles("STAFF");
//        auth.inMemoryAuthentication().withUser("susan").password("{noop}test123").roles("ADMIN");

        auth.jdbcAuthentication()
                .dataSource(myDataSource)
                .usersByUsernameQuery("select username, password, enabled "
                        + "from user "
                        + "where username = ?")
                .authoritiesByUsernameQuery("select username, authority "
                        + "from authorities "
                        + "where username = ?");


    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/access_denied").permitAll()
                .antMatchers("/manager/**").hasAnyRole(fetchServiceRoles("Manage Application"))               //should not start with _ROLE
                .antMatchers("/student/**").hasAnyRole(fetchServiceRoles("Create Petition"))
                .antMatchers("/staff/petition_list/**").hasAnyRole(fetchServiceRoles("Examine Petitions"))
                .antMatchers("/staff/internship_list/**").hasAnyRole(fetchServiceRoles("Examine Internships"))
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .exceptionHandling().accessDeniedPage("/access_denied");

        //.loginProcessingUrl("/authUser") //TODO custom controller page
    }

    public String[] fetchServiceRoles(String name){
        return serviceDAO.getRoles(name);
    }
//public static PasswordEncoder encoder() {
    //    return new BCryptPasswordEncoder();
    //}

}
