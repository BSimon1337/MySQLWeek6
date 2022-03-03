import java.util.stream.Stream;


import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.BeforeEach;

class TestDemoTest {
	
	private TestDemo testDemo;
	
	
	

	@BeforeEach
	void setUp() throws Exception{
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("TestDemoTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, 
			boolean expectException) {
		
		//Given: two numbers to add
		if(expectException) {
			//When: the numbers are added
			//Then: the response is what I expect
			assertThatThrownBy(() -> 
		    testDemo.addPositive(a, b))
		        .isInstanceOf(IllegalArgumentException.class);

		}
		
		else {
			//When: the numbers are added
			//Then: the response is what I expect
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		}
		

	}
	
	static Stream<Arguments> argumentsForAddPositive(){
		//@formatter:off
		return Stream.of(
			arguments(2, 4, 6, false)	
		);
		//@formatter:on
	}
	@Test
	void assertThatNumberSquaredIsCorrect() {
		//Given
		TestDemo mockDemo = spy(testDemo);
		doReturn(5).when(mockDemo).getRandomInt();
		
		//When
		int fiveSquared = mockDemo.randomNumberSquared();
		//Then
		assertThat(fiveSquared).isEqualTo(25);
	}

}
