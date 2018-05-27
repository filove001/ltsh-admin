package study.jar.apache.pool2;

import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

/**
 *
     * Apache commons-pool2使用的基本步骤

     步骤一：实现自己的PooledObjectFactory
     步骤二：创建ObjectPool对象
     步骤三：从ObjectPool获取到PooledObject对象，进行相关业务操作



 /*
 * 这里的池声明用ObjectPool或者GenericObjectPool的区别在于：
 * （1）ObjectPool :
 GenericObjectPool这种对象池的特色是：
 可以设定最多能从池中借出多少个对象。
 可以设定池中最多能保存多少个对象。
 可以设定在池中已无对象可借的情况下，调用它的borrowObject方法时的行为，是等待、创建新的实例还是抛出异常。
 可以分别设定对象借出和还回时，是否进行有效性检查。
 可以设定是否使用一个单独的线程，对池内对象进行后台清理。
 ……
 StackObjectPool：使用LIFO行为实现的ObjectPool。
 SoftReferenceObjectPool：
 使用LIFO行为实现的ObjectPool。此外，在这个对象池实现中，每个对象都会被包装到一个SoftReference中。
 SoftReference允许垃圾回收机制在需要释放内存时回收对象池中的对象。


 源码GenericObjectPool.java类内部的setConfig方法
 1.      参数maxActive指明能从池中借出的对象的最大数目。如果这个值不是正数，表示没有限制。
 2.      参数whenExhaustedA ction指定在池中借出对象的数目已达极限的情况下，调用它的borrowObject方法时的行为。可以选用的值有：
 GenericObjectPool.WHEN_EXHAUSTED_BLOCK，表示等待；
 GenericObjectPool.WHEN_EXHAUSTED_GROW，表示创建新的实例（不过这就使maxActive参数失去了意义）；
 GenericObjectPool.WHEN_EXHAUSTED_FAIL，表示抛出一个java.util.NoSuchElementException异常。
 3.      参数maxWait指明若在对象池空时调用borrowObject方法的行为被设定成等待，最多等待多少毫秒。如果等待时间超过了这个数值，则会抛出一个java.util.NoSuchElementException异常。如果这个值不是正数，表示无限期等待。
 4.      参数testOnBorrow设定在借出对象时是否进行有效性检查。
 5.      参数testOnBorrow设定在还回对象时是否进行有效性检查。
 6.      参数timeBetweenEvictionRunsMillis，设定间隔每过多少毫秒进行一次后台对象清理的行动。如果这个值不是正数，则实际上不会进行后台对象清理。
 7.      参数minEvictableIdleTimeMillis，设定在进行后台对象清理时，视休眠时间超过了多少毫秒的对象为过期。过期的对象将被回收。如果这个值不是正数，那么对休眠时间没有特别的约束。
 8.      参数testWhileIdle，则设定在进行后台对象清理时，是否还对没有过期的池内对象进行有效性检查。不能通过有效性检查的对象也将被回收。
 9.      参数lifo，池对象的放入和取出默认是后进先出的原则，默认是true，代表后进先出，设置为false代表先进先出。
 */
public class MyPooledObjectFactoryExample implements PooledObjectFactory<StringBuffer> {
    /**
     * //创建StringBuffer对象
     */
    @Override
    public PooledObject<StringBuffer> makeObject() throws Exception {
        return new DefaultPooledObject<StringBuffer>(new StringBuffer());
    }
    /**
     * //销毁StringBuffer对象
     */
    @Override
    public void destroyObject(PooledObject<StringBuffer> p) throws Exception {
        StringBuffer sb = p.getObject();
        sb = null;
    }
    /**
     * //校验StringBuffer对象
     */
    @Override
    public boolean validateObject(PooledObject<StringBuffer> p) {
        return p.getObject() != null;
    }
    /**
     * //激活StringBuffer对象
     */
    @Override
    public void activateObject(PooledObject<StringBuffer> p) throws Exception {
        if (null == p.getObject())
            p = new DefaultPooledObject<StringBuffer>(new StringBuffer());
    }
    /**
     * //对话StringBuffer对象，这里是个空实现
     */
    @Override
    public void passivateObject(PooledObject<StringBuffer> p) throws Exception {

    }

    public static void main(String[] args) throws Exception {
        ObjectPool op = new GenericObjectPool<StringBuffer>(new MyPooledObjectFactoryExample(),new GenericObjectPoolConfig());
        //从ObjectPool租借对象StringBuffer
        StringBuffer sb = (StringBuffer) op.borrowObject();
        sb.append("aaa");
        System.out.println(sb.toString());
        //归还对象StringBuffer
        op.returnObject(sb);
    }
}
