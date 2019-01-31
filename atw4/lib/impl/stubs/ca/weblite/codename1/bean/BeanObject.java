package ca.weblite.codename1.bean;


/**
 *  Wraps an object to provide reflection-like capabilities, and tread the wrapped
 *  object as a regular Map.  It depends on a BeanClass which should have been 
 *  implemented with the appropriate property descriptors for the wrapped object.
 *  @author shannah
 */
public class BeanObject implements java.util.Map {

	/**
	 *  Creates a new BeanObject for the specified bean class, to wrap the specified
	 *  object.
	 *  @param klass The BeanClass that serves as the prototype.
	 *  @param bean The object to wrap.
	 */
	public BeanObject(BeanClass klass, Object bean) {
	}

	/**
	 *  Returns the BeanClass for this object.
	 *  @return 
	 */
	public BeanClass getBeanClass() {
	}

	/**
	 *  Returns the wrapped object.
	 *  @return 
	 */
	public Object unwrap() {
	}

	/**
	 *  Returns the sum of the number of properties in the wrapped object and
	 *  the number of entries in the overflow map.
	 *  @return 
	 */
	public int size() {
	}

	/**
	 *  Returns true if the wrapped object contains no properties and the overflow
	 *  map is empty.
	 *  @return 
	 */
	public boolean isEmpty() {
	}

	/**
	 *  Checks to see if this map contains the specified key.  This will return true
	 *  if the wrapped object includes a property with the name of the key, or if 
	 *  the internal overflow map contains a key.
	 *  @param key
	 *  @return 
	 */
	public boolean containsKey(Object key) {
	}

	/**
	 *  Checks to see if the specified value is contained in any of the properties
	 *  of the wrapped object.
	 *  @param value
	 *  @return True if the value is contained in the wrapped object, or in the 
	 *  overflow map.
	 */
	public boolean containsValue(Object value) {
	}

	/**
	 *  Gets the value of a specified property.
	 *  @param key The name of the property to get.
	 *  @return The value of the specified property.
	 */
	public Object get(Object key) {
	}

	/**
	 *  Sets a value in the bean object.  If this key corresponds to a property
	 *  in the wrapped object, then the object's property will be updated directly.
	 *  If the key corresponds to a property that is not writable, then this will
	 *  throw a runtime exception.  If the key doesn't correspond to any property,
	 *  it will be stored in the internal overflow map.
	 *  @param key The name of the property to set.
	 *  @param value The value to set.
	 *  @return The old value
	 */
	public Object put(String key, Object value) {
	}

	/**
	 *  Removes the specified key from the object.  Effectively, this will just
	 *  set the value to null, if it is a property in the wrapped object. If the 
	 *  property is not in the wrapped object, but instead is stored in the internal
	 *  overflow map, then that entry will be removed.
	 *  @param key The key to remove
	 *  @return The removed object.
	 */
	public Object remove(Object key) {
	}

	/**
	 *  Puts all properties from the provided map into the current object.  This
	 *  includes properties that may not be writable so be careful. If you try
	 *  to write a property that is not writable, a RuntimeException will be thrown.
	 *  @param m 
	 *  @see #putAllWritable
	 */
	public void putAll(java.util.Map m) {
	}

	/**
	 *  Puts all properties of the given BeanObject into the current BeanObject.
	 *  Only those properties that are readable in the source, and writable in the 
	 *  target will be copied.
	 *  @param m 
	 */
	public void putAll(BeanObject m) {
	}

	/**
	 *  Checks if the specified property is readable.
	 *  @param key THe name of the property
	 *  @return True if the property is readable.
	 */
	public boolean isReadable(String key) {
	}

	/**
	 *  Checks if the specified property is writable.
	 *  @param key The name of the property.
	 *  @return True if the property is writable.
	 */
	public boolean isWritable(String key) {
	}

	/**
	 *  Returns the type of the specified property.
	 *  @param key The name of the property.
	 *  @return The type of the property as defined in the class.
	 */
	public Class getType(String key) {
	}

	/**
	 *  Sets all properties in the wrapped object which are writable using the 
	 *  values provided in m.
	 *  @param m A map with keys/values to set in the wrapped object.
	 */
	public void putAllWritable(java.util.Map m) {
	}

	/**
	 *  Sets all writable properties to null (or translated primitive value), and clears
	 *  the overflow map.
	 */
	public void clear() {
	}

	/**
	 *  Returns the names of all properties in the wrapped object, and the existing
	 *  keys in the overflow map.
	 *  @return 
	 */
	public java.util.Set keySet() {
	}

	/**
	 *  Returns all of the non-null values of properties in this object - and
	 *  the values in the overflow map.
	 *  @return 
	 */
	public java.util.Collection values() {
	}

	/**
	 *  Returns all entries in the wrapped object, and in the overflow map.
	 *  @return 
	 */
	public java.util.Set entrySet() {
	}

	/**
	 *  Returns all entries for readable properties in the wrapped object.  Does
	 *  not include any entries from the overflow map.
	 *  @return 
	 */
	public java.util.Set readableEntries() {
	}

	/**
	 *  Returns all entries for writable properties in the wrapped object.  Does
	 *  not include any entries from the overflow map.
	 *  @return 
	 */
	public java.util.Set writableEntries() {
	}

	/**
	 *  Returns the names of all properties in the wrapped object that are readable.
	 *  Does not include any keys from the overflow map.
	 *  @return 
	 */
	public java.util.Set readableKeys() {
	}

	/**
	 *  Returns the names of all properties in the wrapped object that are writable.
	 *  Does not include any keys from the overflow map.
	 *  @return 
	 */
	public java.util.Set writableKeys() {
	}

	/**
	 *  Returns values of all non-null readable properties in the wrapped object. Does
	 *  not include any values from the overflow map.
	 *  @return 
	 */
	public java.util.Collection readableValues() {
	}

	/**
	 *  Returns values of all non-null writable properties in the wrapped object. Does
	 *  not include any values from the overflow map.
	 *  @return 
	 */
	public java.util.Collection writableValues() {
	}

	/**
	 *  Returns the properties defined by this schema.
	 *  @return 
	 */
	public java.util.Map getProperties() {
	}

	/**
	 *  Returns all readable properties defined by this schema.
	 *  @return 
	 */
	public java.util.Map getReadableProperties() {
	}

	/**
	 *  Returns all writable properties defined by this schema.
	 *  @return 
	 */
	public java.util.Map getWritableProperties() {
	}
}
