package gregory.tyler.ironworks.user;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void addNewUser(User user) {
        Optional<User> userOptional = userRepository.findUserByEmail(user.getEmail());
        if(userOptional.isPresent()) {
            throw new IllegalStateException("Email already registered");
        }
        userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        boolean exists = userRepository.existsById(userId);
        if(!exists) {
            throw new IllegalStateException("User with id " + userId + " does not exist");
        }
        userRepository.deleteById(userId);
    }

    @Transactional
    public void updateUser(Long userId,
                           String firstName,
                           String lastName,
                           String email,
                           LocalDate dateOfBirth,
                           Float weightInPounds,
                           Integer heightInInches) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException(
                        "user with id " + userId + " does not exist"));

        if(firstName != null &&
                firstName.length() > 0 &&
                !Objects.equals(user.getFirstName(), firstName)) {
            user.setFirstName(firstName);
        }

        if(lastName != null &&
                lastName.length() > 0 &&
                !Objects.equals(user.getFirstName(), lastName)) {
            user.setLastName(lastName);
        }

        if(email != null &&
                email.length() > 0 &&
                !Objects.equals(user.getEmail(), email)) {
            Optional<User> userOptional = userRepository.findUserByEmail(email);
            if(userOptional.isPresent()) {
                throw new IllegalStateException("email taken");
            }
            user.setEmail(email);
        }

        if(dateOfBirth != null &&
                dateOfBirth.isBefore(LocalDate.now())) {
            user.setDateOfBirth(dateOfBirth);
        }

        if(weightInPounds != null &&
                weightInPounds > 0) {
            user.setWeightInPounds(weightInPounds);
        }

        if(heightInInches != null &&
                heightInInches > 0) {
            user.setHeightInInches(heightInInches);
        }
    }
}
