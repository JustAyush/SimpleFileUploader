package docman

class Document {

  String filename
  String fullpath

    static constraints = {
      filename(blank:false, nullable:false)
      fullpath(blank:false, nullable:false)
    }
}
