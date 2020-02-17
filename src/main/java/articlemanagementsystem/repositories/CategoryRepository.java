package articlemanagementsystem.repositories;

import articlemanagementsystem.model.Category;


public class CategoryRepository extends CrudRepository<Category, Long> {
    private static CategoryRepository categoryRepository;

    private CategoryRepository() {}


    @Override
    protected Class<Category> getEntityClass() {
        return Category.class;
    }

    public static CategoryRepository getInstance() {
        if (categoryRepository == null)
            categoryRepository = new CategoryRepository();
        return categoryRepository;
    }
}


