package com.vn.quanlythuvien.services.interfaces;

public class UserService implements IUserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAllByRoleId(2);
    }

    @Override
    public void createUser(CreateUserRequest request) {
        setUpUser(new User(), request);
    }

    @Override
    public void updateUser(int id, CreateUserRequest request) {
        User user = userRepository.getUserById(id);
        setUpUser(user, request.getName(), request.getAge());
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public User findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }
    private void setUpUser(User user, CreateUserRequest request) {
        user.setName(name);
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);
        userRepository.save(user);
    }
}
