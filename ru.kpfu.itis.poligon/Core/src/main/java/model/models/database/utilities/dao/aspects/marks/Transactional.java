package model.models.database.utilities.dao.aspects.marks;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(value = ElementType.METHOD)
public @interface Transactional {}