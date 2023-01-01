package ca.nevisco.outreach.data.dto;

import ca.nevisco.outreach.data.entity.EntityModel;

public interface ModelMapper<T extends EntityModel<T>, Model> {

    T mapFromModel(Model model);

    Model mapToEntity(T entity);
}
