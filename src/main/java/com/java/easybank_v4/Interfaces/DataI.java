package com.java.easybank_v4.Interfaces;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface DataI <Type, IdType>{

    Optional<Type> ajoute(Type type);

    int supprime(IdType id);

    Optional<Type> modifier(Type type);

    Optional<Type> chercherParId(IdType id);

    List<Type> afficher();
 }
