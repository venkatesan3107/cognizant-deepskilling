import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;  // ✅ This import is required

public class MyServiceTest {

    @Test
    public void testVerifyInteraction() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);
        service.fetchData();

        verify(mockApi, times(1)).getData();
        verifyNoMoreInteractions(mockApi);
    }
}
