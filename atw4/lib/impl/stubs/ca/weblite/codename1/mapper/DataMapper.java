package ca.weblite.codename1.mapper;


/**
 * 
 *  @author shannah
 */
public abstract class DataMapper {

	public static boolean DEBUG;

	public static DataMapper.KeyConversion CONVERSION_CAMEL_TO_SNAKE;

	public static DataMapper.KeyConversion CONVERSION_SNAKE_TO_CAMEL;

	public static DataMapper.KeyConversion CONVERSION_NONE;

	public DataMapper() {
	}

	public DataMapper(java.util.Map context) {
	}

	public static DataMapper getGlobal(String name) {
	}

	public static void addGlobal(String name, DataMapper mapper) {
	}

	public static void clearGlobal(String name) {
	}

	/**
	 *  @return the outputDateFormat
	 */
	public com.codename1.l10n.DateFormat getOutputDateFormat() {
	}

	/**
	 *  @param outputDateFormat the outputDateFormat to set
	 */
	public void setOutputDateFormat(com.codename1.l10n.DateFormat outputDateFormat) {
	}

	/**
	 *  @return the outputDatesAsLongs
	 */
	public boolean isOutputDatesAsLongs() {
	}

	/**
	 *  @param outputDatesAsLongs the outputDatesAsLongs to set
	 */
	public void setOutputDatesAsLongs(boolean outputDatesAsLongs) {
	}

	/**
	 *  @return the writeKeyConversion
	 */
	public DataMapper.KeyConversion getWriteKeyConversion() {
	}

	/**
	 *  @param writeKeyConversion the writeKeyConversion to set
	 */
	public void setWriteKeyConversion(DataMapper.KeyConversion writeKeyConversion) {
	}

	/**
	 *  @return the readKeyConversions
	 */
	public java.util.List getReadKeyConversions() {
	}

	/**
	 *  @param readKeyConversions the readKeyConversions to set
	 */
	public void setReadKeyConversions(java.util.List readKeyConversions) {
	}

	protected void init() {
	}

	public void setClassName(String name) {
	}

	public String getClassName() {
	}

	public void setListValueType(String key, Class type) {
	}

	public java.util.Map getListValueTypes() {
	}

	public Class getListValueType(String key) {
	}

	public void unsetListValueType(String key) {
	}

	public static void createContext(java.util.List mappers, DataMapper.Decorator decorator) {
	}

	public static void createContext(java.util.List mappers) {
	}

	public void addDateFormat(com.codename1.l10n.DateFormat fmt) {
	}

	public java.util.List getDateFormats() {
	}

	public void removeDateFormat(com.codename1.l10n.DateFormat fmt) {
	}

	public void clearDateFormats() {
	}

	public boolean exists(java.util.Map map, String key) {
	}

	public Object get(java.util.Map map, String key) {
	}

	public java.util.Map getMap(java.util.Map map, String key, Class cls) {
	}

	public java.util.List getList(java.util.Map map, String key, Class cls) {
	}

	public Object get(java.util.Map map, String key, Class cls) {
	}

	public Object jsonify(Object item) {
	}

	public void set(java.util.Map map, String key, Object value) {
	}

	public boolean getBoolean(java.util.Map map, String key) {
	}

	public byte getByte(java.util.Map map, String key) {
	}

	public char getChar(java.util.Map map, String key) {
	}

	public float getFloat(java.util.Map map, String key) {
	}

	public int getInt(java.util.Map map, String key) {
	}

	public short getShort(java.util.Map map, String key) {
	}

	public double getDouble(java.util.Map map, String key) {
	}

	public long getLong(java.util.Map map, String key) {
	}

	public String getString(java.util.Map map, String key) {
	}

	public java.util.Date getDate(java.util.Map map, String key) {
	}

	public Object getObject(java.util.Map map, String key, Class klass) {
	}

	public java.util.List getObjects(java.util.Map map, String key, Class klass) {
	}

	public java.util.Date[] getDateArray(java.util.Map map, String key) {
	}

	public int[] getIntArray(java.util.Map map, String key) {
	}

	public double[] getDoubleArray(java.util.Map map, String key) {
	}

	protected Object createObject(Class klass) {
	}

	public Object readMap(java.util.Map map, Class klass) {
	}

	public java.util.Map readJSONFromURL(String url) {
	}

	public java.util.Map readJSONFromConnection(com.codename1.io.ConnectionRequest req) {
	}

	public java.util.Map readJSON(java.io.InputStream is, String charset) {
	}

	public Object readJSONFromURL(String url, Class klass) {
	}

	public Object readJSONFromURL(String url, Class klass, String path) {
	}

	public Object readJSONFromConnection(com.codename1.io.ConnectionRequest req, Class klass) {
	}

	public Object readJSONFromConnection(com.codename1.io.ConnectionRequest req, Class klass, String path) {
	}

	public Object readJSON(java.io.InputStream is, String charset, Class klass) {
	}

	public Object readJSON(java.io.InputStream is, String charset, Class klass, String path) {
	}

	public Object readJSON(java.io.InputStream is, Class klass) {
	}

	public Object readJSON(java.io.InputStream is, Class klass, String path) {
	}

	public Object readJSON(String data, Class klass) {
	}

	public abstract void writeMap(java.util.Map dest, Object src) {
	}

	public java.util.Map writeMap(Object src) {
	}

	public abstract void readMap(java.util.Map src, Object dest) {
	}

	public static Object[] toArray(java.util.List l) {
	}

	public void setFieldMapper(String field, FieldMapper mapper) {
	}

	public void removeFieldMapper(String field) {
	}

	public void setFieldMapper(String field, String path) {
	}

	public void register(Class klass, DataMapper mapper) {
	}

	public void unregister(Class klass) {
	}

	public java.util.Map getContext() {
	}

	public void setContext(java.util.Map context) {
	}

	public void setObjectFactory(ObjectFactory f) {
	}

	public ObjectFactory getObjectFactory() {
	}

	public DataMapper getDataMapperForClass(Class cls) {
	}

	/**
	 *  @return the outputJSONReady
	 */
	public boolean isOutputJSONReady() {
	}

	/**
	 *  @param outputJSONReady the outputJSONReady to set
	 */
	public void setOutputJSONReady(boolean outputJSONReady) {
	}

	/**
	 *  @return the silentWriteMap
	 */
	public boolean isSilentWriteMap() {
	}

	/**
	 *  @param silentWriteMap the silentWriteMap to set
	 */
	public void setSilentWriteMap(boolean silentWriteMap) {
	}

	/**
	 *  Reads a list of Maps and produces a list of the converted type
	 *  @param input A list of maps that need to be converted to objects.
	 *  @return A list of objects corresponding to the input maps.
	 */
	public java.util.List parseListOfMaps(java.util.List input, Class outType) {
	}

	/**
	 *  Reads a map of maps to produce a map of the converted type.
	 *  @param input The map of maps that need to be converted to objects.
	 *  @param outType The map of objects corresponding to the input maps.
	 *  @return 
	 */
	public java.util.Map parseMapOfMaps(java.util.Map input, Class outType) {
	}

	public static interface class Decorator {


		public void decorate(DataMapper dataMapper) {
		}
	}

	public static interface class KeyConversion {


		public String convertKey(String key) {
		}
	}
}
