package cn.itcast_03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 把当前项目目录下的a.txt内容复制到当前项目目录下的b.txt中
 * 
 * 复制文件：
 * 数据源：
 * 		a.txt	--	InputStream	--	FileInputStream	--	一次读一个字节
 * 目的地：
 * 		b.txt	--	OutputStream -- FileOutputStream -- 一次写一个字节吗?FileOutputStream 内部带有一个字节缓冲区（默认 8192 字节，不同 JDK 实现可能略有差异）。
连续 write(单个字节) 时，数据先被塞进这个缓冲区；只有当缓冲区满了，或者你显式 flush()/close() 时，才会一次性把整块数据刷给操作系统，真正写入磁盘。
 */
public class CopyFileDemo {
	public static void main(String[] args) throws IOException {
		// 封装数据
		FileInputStream fis = new FileInputStream("a.txt");
		// 封装目的地
		FileOutputStream fos = new FileOutputStream("b.txt");

		// 读数据，写数据
		int by = 0;
		while ((by = fis.read()) != -1) {
			fos.write(by);
		}

		// 释放资源
		fos.close();
		fis.close();
	}
}
