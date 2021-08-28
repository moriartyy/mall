package mall.core.util;

import mall.core.util.tree.*;
import org.junit.jupiter.api.Test;
import org.springframework.core.ResolvableType;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author walter
 */
class ClassUtilsTest {

    @Test
    void resolveGenericType() {
        DummyEventHandler h = new DummyEventHandler();
        assertEquals(DummyEvent.class, ClassUtils.resolveGenericType(h.getClass()));
        assertEquals(DummyEvent.class, h.getEventType());

        assertEquals(Red.class, ClassUtils.resolveGenericTypes(RedAppleTree.class, AppleTree.class)[0]);
        assertEquals(Apple.class, ClassUtils.resolveGenericTypes(RedAppleTree.class, AbstractTree.class)[0]);
        assertEquals(Red.class, ClassUtils.resolveGenericTypes(RedAppleTree.class, AbstractTree.class)[1]);
        assertEquals(Apple.class, ClassUtils.resolveGenericTypes(RedAppleTree.class, Tree.class)[0]);
    }


    @Test
    void test() {
        ResolvableType resolvableType = ResolvableType.forClass(RedAppleTree.class);
        do {

            printType(resolvableType);
        } while ((resolvableType = resolvableType.getSuperType()) != ResolvableType.NONE);

        Arrays.stream(ResolvableType.forClass(RedAppleTree.class).getInterfaces()).forEach(t -> {
            printType(t);
        });

        System.out.println(ResolvableType.forClass(AbstractTree.class).getInterfaces().length);
        System.out.println(AppleTree.class.getGenericInterfaces().length);
    }


    private void printType(ResolvableType resolvableType) {
        System.out.println(resolvableType.getRawClass() == AbstractTree.class);
        System.out.println(resolvableType.getRawClass());
        System.out.println(resolvableType.resolve());
        System.out.println("---------------\r\n");
    }
}