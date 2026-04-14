package stepik.contactsApp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import stepik.contactsApp.model.entity.Contact;
import stepik.contactsApp.model.entity.ContactOwner;
import stepik.contactsApp.model.enums.AppRole;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Primary
@Repository
public class ContactOwnerRepository implements ContactOwnerRepositoryInterface {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ContactOwnerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static class ContactOwnerRowMapper implements RowMapper<ContactOwner> {
        @Override
        public ContactOwner mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new ContactOwner(
                    rs.getString("id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("description"),
                    rs.getString("email"),
                    rs.getString("name"),
                    AppRole.valueOf(rs.getString("role"))
            );
        }
    }

    @Override
    public List<ContactOwner> findAll() {
        String sql = "SELECT id, name, username, description, email, password, role "
                + "FROM contact_owners";
        List<ContactOwner> owners = jdbcTemplate.query(sql, new ContactOwnerRowMapper());
        return owners;
    }

    @Override
    public ContactOwner save(ContactOwner owner) {
        if (owner.getId().isBlank()) {
            // новый владелец контактов
            ContactOwner temp = new ContactOwner();
            owner.setId(temp.getId());
            owner.setRole(temp.getRole());
            String sql = "INSERT INTO contact_owners "
                    + "(id,name,username,description,email,password,role) "
                    + "values(?,?,?,?,?,?,?)";
            jdbcTemplate.update(sql,
                    owner.getId(),
                    owner.getFullName(),
                    owner.getUsername(),
                    owner.getDescription(),
                    owner.getEmail(),
                    owner.getPassword(),
                    owner.getRole().name()
            );
        } else {
            // уже учтённый и обновлённый владелец контактов
            String sql = "UPDATE contact_owners "
                    + "SET name = ?, username = ?, description = ?, "
                    + "email = ?, password = ?, role = ? "
                    + "WHERE id = ?";
            jdbcTemplate.update(sql,
                    owner.getFullName(),
                    owner.getUsername(),
                    owner.getDescription(),
                    owner.getEmail(),
                    owner.getPassword(),
                    owner.getRole().name(),
                    owner.getId());
        }
        return owner;
    }


    @Override
    public boolean deleteById(String id) {
        String sql = "DELETE FROM contact_owners WHERE id = ?";
        return jdbcTemplate.update(sql, id) > 0;
    }

    @Override
    public Optional<ContactOwner> findById(String id) {
        String sql = "SELECT id, name, username, description, email, password, role "
                + "FROM contact_owners WHERE id = ?";
        List<ContactOwner> owners = jdbcTemplate.query(sql, new ContactOwnerRowMapper(), id);
        return owners.isEmpty() ? Optional.empty() : Optional.of(owners.getFirst());
    }

    @Override
    public Optional<ContactOwner> findByEmail(String email) {
        String sql = "SELECT id, name, username, description, email, password, role "
                + "FROM contact_owners WHERE email = ?";
        List<ContactOwner> owners = jdbcTemplate.query(sql, new ContactOwnerRowMapper(), email);
        return owners.isEmpty() ? Optional.empty() : Optional.of(owners.getFirst());
    }

    @Override
    public Optional<ContactOwner> findByUsername(String username) {
        String sql = "SELECT id, name, username, description, email, password, role "
                + "FROM contact_owners WHERE username = ?";
        List<ContactOwner> owners = jdbcTemplate.query(sql, new ContactOwnerRowMapper(), username);
        return owners.isEmpty() ? Optional.empty() : Optional.of(owners.getFirst());
    }

    @Override
    public Optional<List<ContactOwner>> findByKeyword(String keyword) {
        String pattern = "%" + keyword.toLowerCase() + "%";
        String sql = "SELECT id, name, username, description, email, password, role "
                + "FROM contact_owners "
                + "WHERE LOWER(name) LIKE ? "
                + "OR LOWER(username) LIKE ? "
                + "OR LOWER(description) LIKE ? "
                + "OR LOWER(email) LIKE ?";
        List<ContactOwner> owners = jdbcTemplate.query(sql, new ContactOwnerRowMapper(),
                pattern,pattern,pattern,pattern);
        return Optional.of(owners);
    }

}
