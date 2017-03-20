/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olympus.portal.data;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.query.Param;

public interface LoginUserRepository extends JpaRepository<LoginUser, String> {

    LoginUser findByUsername(@Param("username") String username);

}