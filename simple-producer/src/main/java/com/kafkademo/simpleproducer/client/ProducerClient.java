package com.kafkademo.simpleproducer.client;

public interface ProducerClient<T> {

	/**
	 * Send an object with an OperationType of <code>OperationType.DEFAULT</code>
	 * and an auto-generated guid.
	 * 
	 * @param value
	 */
	public void send(T value);

	/**
	 * Send an object with the specified guid and an OperationType of
	 * <code>OperationType.DEFAULT</code>.
	 * 
	 * @param guid
	 * @param value
	 */
	public void send(String guid, T value);

	/**
	 * Send an object with the specified guid and OperationType.
	 * 
	 * @param guid
	 * @param opType
	 * @param value
	 */
	public void send(String guid, OperationType opType, T value);

	/**
	 * Send a delete message with the specified object id, guid and an OperationType
	 * of <code>OperationType.DEELETE</code>
	 * 
	 * @param guid
	 * @param id
	 */
	public void sendDelete(String guid, Long id);

	// Batch related operations

	public void sendStartBatch(String guid, String batchId);

	public void send(String guid, String batchId, OperationType opType, T value);

	public void send(String guid, String batchId, T value);

	public void sendDelete(String guid, String batchId, Long id);

	public void sendEndBatch(String guid, String batchId);

}
