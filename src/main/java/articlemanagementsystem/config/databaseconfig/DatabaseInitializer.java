package articlemanagementsystem.config.databaseconfig;

import articlemanagementsystem.model.*;
import articlemanagementsystem.repositories.CategoryRepository;
import articlemanagementsystem.repositories.RoleRepository;
import articlemanagementsystem.repositories.TagRepository;
import articlemanagementsystem.repositories.UserRepository;


public class DatabaseInitializer {
    public static void signUpAdmin() {
        try {
            UserRepository repository = UserRepository.getInstance();
            repository.save(Admin.getInstance());
        } catch (Exception ignored) {
        }
    }

    public static void initCategoryTable() {
        try {
            CategoryRepository repository = CategoryRepository.getInstance();
            if (repository.findAll().isEmpty()) {
                repository.save(new Category(null, "computer", "computer_desc"));
                repository.save(new Category(null, "electronic", "electronic_desc"));
                repository.save(new Category(null, "chemistry", "chemistry_desc"));
                repository.save(new Category(null, "physics", "physics_desc"));
                repository.save(new Category(null, "mathematics", "mathematics_desc"));
                repository.save(new Category(null, "sport", "sport_desc"));
                repository.save(new Category(null, "politics", "politics_desc"));
                repository.save(new Category(null, "cultural", "cultural_desc"));
                repository.save(new Category(null, "social", "social_desc"));
                repository.save(new Category(null, "religious", "religious_desc"));
                repository.save(new Category(null, "military", "military_desc"));
            }
        } catch (Exception ignored) {
        }
    }

    public static void initTagTable() {
        try {
            TagRepository repository = TagRepository.getInstance();
            if (repository.findAll().isEmpty()) {
                repository.save(new Tag(null, "hardware"));
                repository.save(new Tag(null, "artificial_intelligence"));
                repository.save(new Tag(null, "machine_learning"));
                repository.save(new Tag(null, "natural_language_processing"));
                repository.save(new Tag(null, "data_mining"));
                repository.save(new Tag(null, "software_architecture"));
                repository.save(new Tag(null, "design_pattern"));
                repository.save(new Tag(null, "internet_of_things"));
                repository.save(new Tag(null, "security"));
                repository.save(new Tag(null, "chemistry"));
                repository.save(new Tag(null, "social"));
                repository.save(new Tag(null, "cultural"));
                repository.save(new Tag(null, "religious"));
                repository.save(new Tag(null, "soccer"));
                repository.save(new Tag(null, "basketball"));
                repository.save(new Tag(null, "quantum_physics"));
                repository.save(new Tag(null, "classic_physics"));
                repository.save(new Tag(null, "algebra"));
                repository.save(new Tag(null, "graph"));
                repository.save(new Tag(null, "combinatorial"));
                repository.save(new Tag(null, "analytics"));
                repository.save(new Tag(null, "politics"));
                repository.save(new Tag(null, "power_electronics"));
                repository.save(new Tag(null, "digital_electronics"));
                repository.save(new Tag(null, "control"));
                repository.save(new Tag(null, "robotics"));
                repository.save(new Tag(null, "block_chain"));
                repository.save(new Tag(null, "military"));
            }
        } catch (Exception ignored) {
        }
    }

    public static void initRoleTable() {
        try {
            RoleRepository repository = RoleRepository.getInstance();
            if (repository.findAll().isEmpty()) {
                repository.save(new Role(null, "admin"));
                repository.save(new Role(null, "writer"));
            }
        } catch (Exception ignored) {
        }
    }
}
