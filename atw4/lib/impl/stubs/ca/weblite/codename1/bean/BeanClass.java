package ca.weblite.codename1.bean;


/**
 * 
 *  @author shannah
 */
public abstract class BeanClass {

	public BeanClass() {
	}

	public static void register(Class cls, BeanClass bc) {
	}

	public static BeanObject wrap(Object bean) {
	}

	public static BeanObject wrap(Object bean, Class cls) {
	}

	public Object get(Object bean, String property) {
	}

	public void set(Object bean, String key, Object value) {
	}

	public java.util.Map getProperties() {
	}

	protected void addProperty(BeanClass.Property prop) {
	}

	public abstract Class getWrappedClass() {
	}

	public static interface class Property {


		public String getName() {
		}

		public Class getType() {
		}

		public Object get(Object bean) {
		}

		public void set(Object bean, Object value) {
		}

		public boolean isReadable() {
		}

		public boolean isWritable() {
		}
	}
}
