package com.br.finances.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "user")
public class User implements UserDetails, Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true)
  private String userName;
  private String fullName;
  private String password;
  private Boolean accountNonExpired;
  private Boolean accountNonlocked;
  private Boolean credentialNonExpired;
  private Boolean enabled;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(
      name = "permission",
      joinColumns = {
          @JoinColumn(name = "id_user")
      },
      inverseJoinColumns = {
          @JoinColumn(name = "id_permission")
      }
  )
  private List<Permission> permissions;


  public Long getId() {
    return id;
  }

  public String getUserName() {
    return userName;
  }

  public String getFullName() {
    return fullName;
  }

  public Boolean getAccountNonExpired() {
    return accountNonExpired;
  }

  public Boolean getAccountNonlocked() {
    return accountNonlocked;
  }

  public Boolean getCredentialNonExpired() {
    return credentialNonExpired;
  }

  public Boolean getEnabled() {
    return enabled;
  }

  public List<Permission> getPermissions() {
    return permissions;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setAccountNonExpired(Boolean accountNonExpired) {
    this.accountNonExpired = accountNonExpired;
  }

  public void setAccountNonlocked(Boolean accountNonlocked) {
    this.accountNonlocked = accountNonlocked;
  }

  public void setCredentialNonExpired(Boolean credentialNonExpired) {
    this.credentialNonExpired = credentialNonExpired;
  }

  public void setEnabled(Boolean enabled) {
    this.enabled = enabled;
  }

  public void setPermissions(List<Permission> permissions) {
    this.permissions = permissions;
  }

  public List<String> getRoles() {
    List<String> roles = new ArrayList<>();
    for (Permission p: this.permissions) {
      roles.add(p.getDescription());
    }
    return roles;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof User)) return false;
    User user = (User) o;
    return getId().equals(user.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId());
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return this.permissions;
  }

  @Override
  public String getPassword() {
    return this.password;
  }

  @Override
  public String getUsername() {
    return this.userName;
  }

  @Override
  public boolean isAccountNonExpired() {
    return this.accountNonExpired;
  }

  @Override
  public boolean isAccountNonLocked() {
    return this.accountNonlocked;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return this.credentialNonExpired;
  }

  @Override
  public boolean isEnabled() {
    return this.enabled;
  }
}
