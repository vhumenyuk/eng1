package eng.service.mapper;

import eng.dto.UserDTO;
import eng.entity.Role;
import eng.entity.User;
import eng.entity.UserDetailsImpl;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-07T21:19:50+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_181 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO toDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( user.getId() );
        userDTO.setFirstName( user.getFirstName() );
        userDTO.setLastName( user.getLastName() );
        userDTO.setEmail( user.getEmail() );
        userDTO.setPassword( user.getPassword() );

        return userDTO;
    }

    @Override
    public User toEntity(UserDTO userDTO) {
        if ( userDTO == null ) {
            return null;
        }

        User user = new User();

        user.setId( userDTO.getId() );
        user.setFirstName( userDTO.getFirstName() );
        user.setLastName( userDTO.getLastName() );
        user.setEmail( userDTO.getEmail() );
        user.setPassword( userDTO.getPassword() );

        return user;
    }

    @Override
    public UserDetailsImpl toUserDetails(User user) {
        if ( user == null ) {
            return null;
        }

        UserDetailsImpl userDetailsImpl = new UserDetailsImpl();

        Set<Role> set = user.getRoles();
        if ( set != null ) {
            userDetailsImpl.setAuthorities( new HashSet<Role>( set ) );
        }
        userDetailsImpl.setEmail( user.getEmail() );
        userDetailsImpl.setPassword( user.getPassword() );

        return userDetailsImpl;
    }
}
