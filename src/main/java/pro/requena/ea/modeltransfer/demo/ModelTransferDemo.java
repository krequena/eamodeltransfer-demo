package pro.requena.ea.modeltransfer.demo;

import pro.requena.ea.modeltransfer.ModelTransfer;

/**
 * Project main access point.
 *
 * @author krequena
 *
 */
public class ModelTransferDemo {

	private static final String POSTGRESQL_DRIVER_CLASSNAME = "org.postgresql.Driver";
	private static final String SOURCE = "jdbc:postgresql://localhost:5432/postgres?user=postgres&password=password";

	/**
	 * Main Method.
	 *
	 * @param args Arguments.
	 */
	public static void main(final String[] args) {
		if (args.length != 1) {
			System.err.println("Usage: ea-backup.jar target_file.eapx");
			return;
		}
		try {
			Class.forName(POSTGRESQL_DRIVER_CLASSNAME);
			final ModelTransfer modelTransfer = new ModelTransfer();
			modelTransfer.transfer(SOURCE, args[0], true);
		} catch (final Exception e) {
			System.err.println("An exception has occurred.");
			e.printStackTrace();
		}
	}

}
