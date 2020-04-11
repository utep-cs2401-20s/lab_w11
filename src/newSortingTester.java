import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class newSortingTester {
    newSorting ns = new newSorting();
    int[] A;

    @Test
    void test_newSorting0() {
        A = new int[]{63432,123,6543,64353,234231};
        ns.newSorting(A,5);
        assertArrayEquals(new int[]{123,6543,63432,64353,234231},A);
    }

    @Test
    void test_newSorting1() {
        A = new int[]{458976,5432,1234,8764};
        ns.newSorting(A,2);
        assertArrayEquals(new int[]{1234,5432,8764,458976},A);
    }

    @Test
    void test_newSorting2() {
        A = new int[]{458976,458976,1234,1234,1234,1234};
        ns.newSorting(A,3);
        assertArrayEquals(new int[]{1234,1234,1234,1234,458976,458976},A);
    }

    @Test
    void test_newSorting3() {
        A = new int[]{};
        ns.newSorting(A,10000);
        assertArrayEquals(new int[]{},A);
    }

    @Test
    void test_newSorting4() {
        A = new int[20000]; //java initializes int arrays to 1
        ns.newSorting(A,50);
        assertArrayEquals(new int[20000],A);
    }

    /* *************** Testing private methods *************** */
    /* These tests are unit testing private methods that must be made visible and static to run. */
    @Test
    void test_populate() {
        A = new int[]{4,2,3,8,4,4,1,7,16};
        int[] LH = new int[A.length/2];
        int[] RH = new int[A.length-A.length/2];
        //newSorting.populate(A,LH,RH);
        assertArrayEquals(new int[]{4,2,3,8},LH);
        assertArrayEquals(new int[]{4,4,1,7,16},RH);
    }

    @Test
    void test_mergeSortedHalves() {
        A = new int[]{4,2,3,8,4,4,1,7,16};
        //ns.mergeSortedHalves(A,new int[]{2,3,4,4,8},new int[]{1,4,7,16});
        assertArrayEquals(new int[]{1,2,3,4,4,4,7,8,16},A);
    }
}