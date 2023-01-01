package ca.nevisco.outreach.data.dao;

import java.io.Serializable;
import java.util.List;

public interface AbstractDao<T extends Serializable> {

    List<? extends Serializable> findAll();

    void save(T t);
}
