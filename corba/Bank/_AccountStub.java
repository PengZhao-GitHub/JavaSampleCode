package Bank;

/**
 * <ul>
 * <li> <b>IDL Source</b>    "Bank.idl"
 * <li> <b>IDL Name</b>      ::Bank::Account
 * <li> <b>Repository Id</b> IDL:Bank/Account:1.0
 * </ul>
 * <b>IDL definition:</b>
 * <pre>
 * interface Account {
  ...
};
 * </pre>
 */
public class _AccountStub extends com.inprise.vbroker.CORBA.portable.ObjectImpl implements Bank.Account {
  final public static java.lang.Class _opsClass = Bank.AccountOperations.class;

  public java.lang.String[] _ids () {
    return __ids;
  }

  private static java.lang.String[] __ids = {
    "IDL:Bank/Account:1.0"
  };

  /**
   * <pre>
   *   float balance ();
   * </pre>
   */
  public float balance () {

    while (true) {
      if (!_is_local()) {
        org.omg.CORBA.portable.OutputStream _output = null;
        org.omg.CORBA.portable.InputStream  _input  = null;
        float _result;
        try {
          _output = this._request("balance", true);
          _input = this._invoke(_output);
          _result = _input.read_float();
          return _result;
        }
        catch (org.omg.CORBA.portable.ApplicationException _exception) {
          final org.omg.CORBA.portable.InputStream in = _exception.getInputStream();
          java.lang.String _exception_id = _exception.getId();
          throw new org.omg.CORBA.UNKNOWN("Unexpected User Exception: " + _exception_id);
        }
        catch (org.omg.CORBA.portable.RemarshalException _exception) {
          continue;
        }
        finally {
          this._releaseReply(_input);
        }
      } else {
        final org.omg.CORBA.portable.ServantObject _so = _servant_preinvoke("balance", _opsClass);
        if (_so == null) {
          continue;
        }
        final Bank.AccountOperations _self = (Bank.AccountOperations)_so.servant;
        try {
          return _self.balance();
        }
        finally {
          _servant_postinvoke(_so);
        }
      }
    }
  }

}
