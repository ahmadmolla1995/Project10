package articlemanagementsystem.repositories;

import articlemanagementsystem.model.Tag;


public class TagRepository extends CrudRepository<Tag, Long> {
    private static TagRepository tagRepository;

    private TagRepository() {}

    @Override
    protected Class<Tag> getEntityClass() {
        return Tag.class;
    }

    public static TagRepository getInstance() {
        if (tagRepository == null)
            tagRepository = new TagRepository();
        return tagRepository;
    }

}
