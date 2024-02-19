package mtimer;

/**
 * 一个基于UNIX时间戳来计算时间的计时器。<br>
 * 必须实例化对象使用，修改为静态可能会导致计时冲突<br>
 * 有start()、pause()、go()、end()方法对外开放。cmpt()方法是不对外开放的。<br>
 * @author github.com upbingun
 * @since JDK17
 */
public class MTimer {
	private long sTime;
	private long t=0;
	/**
	 * 开始计时，不返回任何东西。<br>
	 */
	public void start() {
		sTime=System.currentTimeMillis();
	}
	/**
	 * 计算一遍现在所累计的值。<br>
	 * @return 现在的t（也就是时间）值，是私有的，注意t是long类型<br>
	 */
	private long cmpt() {
		t=t+(sTime-System.currentTimeMillis());
		return t;
	}
	/**
	 * 用于暂停计数<br>
	 * 实际上调用了cmpt()方法（是私有的）<br>
	 */
	public void pause() {
		cmpt();
	}
	/**
	 * 继续计数。<br>
	 * 实际上调用了start()方法。<br>
	 */
	public void go() {
		start();
	}
	/**
	 * 结束当前的计时（注意不是暂停）。<br>
	 * 调用cmpt()方法（注意是私有的），来计算一遍当前的时间。<br>
	 * 本end()方法返回的是毫秒时间<br>
	 * @return 毫秒时间，long类型<br>
	 */
	public long end() {
		return cmpt();
	}
	/**
	 * 结束当前计时（注意不是暂停）。<br>
	 * 调用cmpt方法（私有），来计算当前的时间。<br>
	 * 该方法是四舍五入的，因此如果计时较短（小于1000ms）时会返回0，为了防止by zero这种情况返回1。<br>
	 * @return 秒级时间，long类型<br>
	 */
	public long endS() {
		long totalT=cmpt();
		if(totalT<1000) {
			totalT=1;
		}
		return totalT;
	}
	/**
	 * 构造方法，不做任何事情<br>
	 */
	public MTimer() {}
}

