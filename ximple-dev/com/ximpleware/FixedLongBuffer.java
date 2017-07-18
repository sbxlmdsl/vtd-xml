/* 
 * Copyright (C) 2002-2017 XimpleWare, info@ximpleware.com
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 */
/*VTD-XML is protected by US patent 7133857, 7260652, an 7761459*/
/*All licenses to any parties in litigation with XimpleWare have been expressly terminated. No new license, and no renewal of any revoked license, 
 * is granted to those parties as a result of re-downloading software from this or any other website*/

package com.ximpleware;

public class FixedLongBuffer extends FastLongBuffer {
	private long[] storage;
	//private int size;
	
	public FixedLongBuffer(int cap){	
		storage = new long[cap];
		size =0;
	}
	public int getSize(){
		return size;
	}
	
	public int getCapacity(){
		return storage.length;
	}
	
	public void append(long[] la){
		System.arraycopy(la, 0, storage, size, la.length);
	}
    
	public void append(long l){
		storage[size]=l;
		size++;
	}
	
	public long longAt(int index){
		return storage[index];
	}
	
	public int upper32At(int index){
		return (int)(storage[index]>>32);
	}
	
	public int lower32At(int index){
		return (int)storage[index];
	}
	
	public long[] getLongArray(int startingOffset, int len){
		long[] la = new long[len];
		System.arraycopy(storage, startingOffset, la, 0, len);
		return la;
	}
	
	public long[] toLongArray(){
		return storage.clone();
	}
	
	public void resize(){}
	
	public void modifyEntry(int index, long l){
		storage[index]=l;
	}
}
