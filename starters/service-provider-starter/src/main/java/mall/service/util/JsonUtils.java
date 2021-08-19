package mall.service.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BiConsumer;

/**
 * @author walter
 */
public class JsonUtils {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final ConcurrentMap<Type, JavaType> JAVA_TYPE_MAP = new ConcurrentHashMap<>();

    static {
        MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        MAPPER.registerModule(createDateTimeModule());
    }

    public static SimpleModule createDateTimeModule() {
        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDate.class, new LocalDateSerializer(DATE_FORMATTER));
        module.addSerializer(LocalTime.class, new LocalTimeSerializer(TIME_FORMATTER));
        module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DATE_TIME_FORMATTER));
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer(DATE_FORMATTER));
        module.addDeserializer(LocalTime.class, new LocalTimeDeserializer(TIME_FORMATTER));
        module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DATE_TIME_FORMATTER));
        return module;
    }

    public static void addDateTimeSerializers(BiConsumer<Class<?>, JsonSerializer<?>> consumer) {
        consumer.accept(LocalDate.class, new LocalDateSerializer(DATE_FORMATTER));
        consumer.accept(LocalTime.class, new LocalTimeSerializer(TIME_FORMATTER));
        consumer.accept(LocalDateTime.class, new LocalDateTimeSerializer(DATE_TIME_FORMATTER));
    }

    public static void addDateTimeDeserializers(BiConsumer<Class<?>, JsonDeserializer<?>> consumer) {
        consumer.accept(LocalDate.class, new LocalDateDeserializer(DATE_FORMATTER));
        consumer.accept(LocalTime.class, new LocalTimeDeserializer(TIME_FORMATTER));
        consumer.accept(LocalDateTime.class, new LocalDateTimeDeserializer(DATE_TIME_FORMATTER));
    }

    public static String serializeToString(Object obj) {
        try {
            return MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to serialize obj", e);
        }
    }

    public static byte[] serialize(Object obj) {
        try {
            return MAPPER.writeValueAsBytes(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to serialize obj", e);
        }
    }

    public static <T> T deserialize(byte[] source, Class<T> type) {
        try {
            return MAPPER.readValue(source, type);
        } catch (Exception e) {
            throw new RuntimeException("Failed to deserialize source", e);
        }
    }

    public static <T> T deserializeFromString(String source, Class<T> type) {
        try {
            return MAPPER.readValue(source, type);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to deserialize source", e);
        }
    }

    public static Object deserializeFromString(String source, Type type) {
        try {
            JavaType javaType = JAVA_TYPE_MAP.computeIfAbsent(type, t -> MAPPER.getTypeFactory().constructType(t));
            return MAPPER.readValue(source, javaType);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to deserialize source", e);
        }
    }

}
