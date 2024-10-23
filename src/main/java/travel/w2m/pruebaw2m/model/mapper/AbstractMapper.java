package travel.w2m.pruebaw2m.model.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The Class AbstractMapper.
 *
 * @param <T>
 *        the generic type
 * @param <S>
 *        the generic type
 */
public abstract class AbstractMapper <T, S> {

	/**
	 * Map.
	 *
	 * @param item
	 *        the item
	 * @return the t
	 */
	public abstract T map (S entity);

	/**
	 * Map aux.
	 *
	 * @param item
	 *        the item
	 * @return the s
	 */
	public abstract S mapAux (T item);

	/**
	 * Map.
	 *
	 * @param items
	 *        the items
	 * @return the list
	 */
	public List<T> map (Collection<S> entities) {
		return entities.stream().map(this::map).collect(Collectors.toList());
	}

	/**
	 * Map aux.
	 *
	 * @param items
	 *        the items
	 * @return the list
	 */
	public List<S> mapAux (Collection<T> items) {
		return items.stream().map(this::mapAux).collect(Collectors.toList());
	}

}