package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class ArrayListRepository<T, ID> implements Repository<T, ID> {

    private final List<T> storage = new ArrayList<>();
    private final Function<T, ID> extratorId;

    public ArrayListRepository(Function<T, ID> extratorId) {
        this.extratorId = extratorId;
    }

    @Override
    public T salvar(T entity) {
        ID id = extratorId.apply(entity);

        buscarPorId(id).ifPresent(storage::remove);

        storage.add(entity);
        return entity;
    }

    @Override
    public Optional<T> buscarPorId(ID id) {
        return storage.stream()
                .filter(e -> extratorId.apply(e).equals(id))
                .findFirst();
    }

    @Override
    public List<T> buscarTodos() {
        return new ArrayList<>(storage);
    }

    @Override
    public boolean removerPorId(ID id) {
        return storage.removeIf(e -> extratorId.apply(e).equals(id));
    }
}
