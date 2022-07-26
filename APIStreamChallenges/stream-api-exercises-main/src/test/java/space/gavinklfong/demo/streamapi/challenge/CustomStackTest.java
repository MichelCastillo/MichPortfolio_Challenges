package space.gavinklfong.demo.streamapi.challenge;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

import static java.util.Collections.singletonList;
import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static space.gavinklfong.demo.streamapi.challenge.CustomStack.partitionAdults;

class CustomStackTest {

    @Test
    public void partitionAdultsShouldSeparateKidsFromAdults() {
        Person sara = new Person("Sara", 4);
        Person viktor = new Person("Viktor", 40);
        Person eva = new Person("Eva", 42);
        List<Person> collection = asList(sara, eva, viktor);
        Map<Boolean, List<Person>> result = partitionAdults(collection);
        assertThat(result.get(true)).hasSameElementsAs(asList(viktor, eva));
        assertThat(result.get(false)).hasSameElementsAs(singletonList(sara));
    }
}