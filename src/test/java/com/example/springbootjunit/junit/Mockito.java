package com.example.springbootjunit.junit;

import com.example.springbootjunit.pojo.User;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.*;

import static org.mockito.Mockito.*;

/**
 * @author wang
 */
public class Mockito {
    @Test
    public void createMockObject() {
        // 使用 mock 静态方法创建 Mock 对象.
        List mockedList = mock(List.class);
        User mock = mock(User.class);
        Assert.assertTrue(mockedList instanceof List);
        Assert.assertTrue(mock instanceof User);
        // mock 方法不仅可以 Mock 接口类, 还可以 Mock 具体的类型.
        ArrayList mockedArrayList = mock(ArrayList.class);
        Assert.assertTrue(mockedArrayList instanceof List);
        Assert.assertTrue(mockedArrayList instanceof ArrayList);
    }


    /**
     * 配置 Mock 对象
     */
    @Test
    public void configMockObject() {
        List mockedList = mock(List.class);
        // 我们定制了当调用 mockedList.add("one") 时, 返回 true
        when(mockedList.add("one")).thenReturn(true);
        // 当调用 mockedList.size() 时, 返回 3
        when(mockedList.size()).thenReturn(3);
        when(mockedList.get(0)).thenReturn("one");
        //调用抛出异常
        when(mockedList.get(2)).thenThrow(NullPointerException.class);
        mockedList.get(2);
        Assert.assertTrue(mockedList.add("one"));
        // 因为我们没有定制 add("two"), 因此返回默认值, 即 false.
        Assert.assertFalse(mockedList.add("two"));
        Assert.assertEquals(mockedList.size(), 3);
        Iterator i = mock(Iterator.class);
        when(i.next()).thenReturn("Hello,").thenReturn("Mockito!");
        String result = i.next() + " " + i.next();
        //assert
        Assert.assertEquals("Hello, Mockito!", result);
    }


    @Test(expected = NoSuchElementException.class)
    public void testForIOException() throws Exception {
        Iterator i = mock(Iterator.class);
        when(i.next()).thenReturn("Hello,").thenReturn("Mockito!"); // 1
        String result = i.next() + " " + i.next(); // 2
        Assert.assertEquals("Hello, Mockito!", result);

        doThrow(new NoSuchElementException()).when(i).next(); // 3
        i.next(); // 4
    }

    /**
     * 校验 Mock 对象的方法调用
     * 第一句校验 mockedList.add("one") 至少被调用了 1 次(atLeastOnce)
     * 第二句校验 mockedList.add("two") 被调用了 1 次(times(1))
     * 第三句校验 mockedList.add("three times") 被调用了 3 次(times(3))
     * 第四句校验 mockedList.isEmpty() 从未被调用(never)
     */
    @Test
    public void testVerify() {
        List mockedList = mock(List.class);
        mockedList.add("one");
        mockedList.add("two");
        mockedList.add("three times");
        mockedList.add("three times");
        mockedList.add("three times");
        when(mockedList.size()).thenReturn(5);
        Assert.assertEquals(mockedList.size(), 5);
        verify(mockedList, atLeastOnce()).add("one");
        verify(mockedList, times(1)).add("two");
        verify(mockedList, times(3)).add("three times");
        verify(mockedList, never()).isEmpty();
    }

    /**
     * 使用 spy() 部分模拟对象
     */
    @Test
    public void testSpy() {
        List list = new LinkedList();
        List spy = spy(list);
        // 对 spy.size() 进行定制.
        when(spy.size()).thenReturn(100);
        spy.add("one");
        spy.add("two");
        // 因为我们没有对 get(0), get(1) 方法进行定制,
        // 因此这些调用其实是调用的真实对象的方法.
        Assert.assertEquals(spy.get(0), "one");
        Assert.assertEquals(spy.get(1), "two");
        Assert.assertEquals(spy.size(), 100);
    }

    /**
     * 参数捕获
     * verify(mockedList).addAll(argument.capture()) 语句来获取 mockedList.addAll 方法所传递的实参 list
     */
    @Test
    public void testCaptureArgument() {
        List<String> list = Arrays.asList("1", "2");
        List mockedList = mock(List.class);
        ArgumentCaptor<List> argument = ArgumentCaptor.forClass(List.class);
        mockedList.addAll(list);
        verify(mockedList).addAll(argument.capture());
        Assert.assertEquals(2, argument.getValue().size());
        Assert.assertEquals(list, argument.getValue());
    }
}
