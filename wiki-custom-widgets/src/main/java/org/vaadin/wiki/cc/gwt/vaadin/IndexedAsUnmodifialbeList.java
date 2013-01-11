package org.vaadin.wiki.cc.gwt.vaadin;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import com.google.gwt.view.client.ProvidesKey;
import com.vaadin.data.Container.Indexed;
import com.vaadin.data.Item;

/** 
 * Read-only implementation
 */
public class IndexedAsUnmodifialbeList<E extends Item> implements List<E> {
	
	private final Indexed wrapped;
	
	private final ProvidesKey<E> keyProvider;
	
	public IndexedAsUnmodifialbeList(Indexed ordered, ProvidesKey<E> keyProvider) {
		this.wrapped = ordered;
		this.keyProvider = keyProvider;
	}

	@Override
	public int size() {
		return wrapped.size();
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public boolean contains(Object o) {
		return wrapped.containsId(keyProvider.getKey((E) o));
	}

	@Override
	public Iterator<E> iterator() {
		return listIterator();
	}

	@Override
	public Object[] toArray() {
		throw new UnsupportedOperationException();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean add(E e) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean remove(Object o) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		boolean result = true;
		for (Object o: c) {
			if (!contains(o)) {
				result = false;
				break;
			}
		}
		return result;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void clear() {
		throw new UnsupportedOperationException();
	}

	@Override
	public E get(int index) {
		final Object itemId = wrapped.getIdByIndex(index);
		return (E) wrapped.getItem(itemId);
	}

	@Override
	public E set(int index, E element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public void add(int index, E element) {
		throw new UnsupportedOperationException();
	}

	@Override
	public E remove(int index) {
		throw new UnsupportedOperationException();
	}

	@Override
	public int indexOf(Object o) {
		final Object itemId = keyProvider.getKey((E) o);
		return wrapped.indexOfId(itemId);
	}

	@Override
	public int lastIndexOf(Object o) {
		final Object itemId = keyProvider.getKey((E) o);
		// ???
		return wrapped.indexOfId(itemId);
	}

	@Override
	public ListIterator<E> listIterator() {
		return listIterator(0);
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		final Object firstId = wrapped.getIdByIndex(index);
		return new IndexedListIterator<E>(wrapped, firstId);
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		throw new UnsupportedOperationException();
	}
	
	private static class IndexedListIterator<E> implements ListIterator<E> {
		
		private final Indexed wrapped;
		
		private boolean hasNext = true;
		
		private boolean hasPrevious = true;
		
		private Object currentItemId;
		
		private IndexedListIterator(Indexed wrapped, Object firstItemId) {
			this.wrapped = wrapped;
			this.currentItemId = firstItemId;
			if (firstItemId == null) {
				hasNext = false;
				hasPrevious = false;
			}
		}

		@Override
		public boolean hasNext() {
			return hasNext;
		}

		@Override
		public E next() {
			if (!hasNext) {
				throw new NoSuchElementException();
			}
			final E result = (E) wrapped.getItem(currentItemId);
			final Object nextItemId = wrapped.nextItemId(currentItemId);
			if (nextItemId == null) {
				hasNext = false;
			}
			else {
				currentItemId = nextItemId;
			}
			return result;
		}

		@Override
		public boolean hasPrevious() {
			return hasPrevious;
		}

		@Override
		public E previous() {
			if (!hasPrevious) {
				throw new NoSuchElementException();
			}
			final Object prevItemId = wrapped.prevItemId(currentItemId);
			if (prevItemId == null) {
				hasPrevious = false;
			}
			else {
				currentItemId = prevItemId;
			}
			if (!hasPrevious) {
				throw new NoSuchElementException();
			}
			final E result = (E) wrapped.getItem(currentItemId);
			return result;
		}

		@Override
		public int nextIndex() {
			if (currentItemId == null) {
				hasNext = false;
			}
			if (!hasNext) {
				throw new NoSuchElementException();
			}
			return wrapped.indexOfId(currentItemId);
		}

		@Override
		public int previousIndex() {
			if (!hasPrevious) {
				throw new NoSuchElementException();
			}
			return wrapped.indexOfId(currentItemId) - 1;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

		@Override
		public void set(E e) {
			throw new UnsupportedOperationException();
		}

		@Override
		public void add(E e) {
			throw new UnsupportedOperationException();
		}		
		
	}

}
