package stepik.contactsApp.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import stepik.contactsApp.model.dto.ContactOwnerDTO;
import stepik.contactsApp.model.entity.ContactOwner;

@Configuration
public class MapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();

        mapper.getConfiguration()
                .setImplicitMappingEnabled(true)
                .setSkipNullEnabled(true);

        return mapper;
    }

    private void configureGetContactOwnerAll(ModelMapper mapper){
        mapper.typeMap(ContactOwner.class, ContactOwnerDTO.class)
                .addMappings(m -> {
                    m.map(ContactOwner::getId, ContactOwnerDTO::setId);
                    m.map(ContactOwner::getUsername, ContactOwnerDTO::setUsername);
                    m.map(ContactOwner::getDescription, ContactOwnerDTO::setDescription);
                    m.map(ContactOwner::getEmail, ContactOwnerDTO::setEmail);
                    m.map(ContactOwner::getFullName, ContactOwnerDTO::setFullName);
                    m.map(ContactOwner::getRole, ContactOwnerDTO::setRole);
                });
    }
}
