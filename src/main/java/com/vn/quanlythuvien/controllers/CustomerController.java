package com.vn.quanlythuvien.controllers;

@Controller
@RequestMapping(routes.CUSTOMER)
public class CustomerController {

    private final IUserService userService;
    private final UserRepository userRepository;

    @Autowired
    public CustomerController(
            IUserService userService,
            UserRepository userRepository
    ) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("customers", this.userRepository.findAll());
        return "customer/index";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("customer", new UserRequest());
        return "customer/create";
    }

    @PostMapping("/store")
    public String store(
            @ModelAttribute("customer") CustomerRequest request,
            Model model
    ) {
        this.userService.createUser(request);
        return "redirect:" + routes.CUSTOMER;
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(
            @PathVariable("id") Long id,
            Model model
    ) {
        Optional<Customer> customer = this.userRepository.findById(id);
        if (customer.isPresent()) {
            model.addAttribute("customer", new CustomerRequest(customer.get()));
            return "customer/edit";
        }
        return "redirect:" + routes.CUSTOMER;
    }

    @PostMapping("/update/{id}")
    public String update(
            @PathVariable("id") Long id,
            @ModelAttribute("customer") CustomerRequest request,
            Model model
    ) {
        this.userService.updateUser(id, request);
        return "redirect:" + routes.CUSTOMER;
    }

    @GetMapping("/search")
    public String search(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "phone", required = false) String phone,
            Model model
    ) {
        model.addAttribute("customers", this.userService.searchUser(name, email, phone));
        return "customer/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(
            @PathVariable("id") Long id,
            Model model
    ) {
        this.userService.deleteUser(id);
        return "redirect:" + routes.CUSTOMER;
    }
}