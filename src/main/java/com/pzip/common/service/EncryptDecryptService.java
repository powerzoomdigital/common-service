/**
 * 
 */
package com.pzip.common.service;

/**
 * @author Nadeem
 *
 */
public interface EncryptDecryptService {
	public String encrypt(String algorithm, String cipherText);
	public String decrypt(String algorithm, String cipherText);
}
