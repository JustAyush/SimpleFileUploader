package docman

class DocumentController {

    def index() {
      redirect ( action:'list' )
    }

    def create() {

    }

    def list() {
      def doclist = Document.list(params)
      [documentInstanceList: doclist]
    }

    def upload() {
      def file = request.getFile('file')

      def documentInstance = new Document()
      documentInstance.filename = file.originalFilename
      documentInstance.fullpath = "f:/FromDiskG/grailsProject/" + documentInstance.filename
      file.transferTo(new File(documentInstance.fullpath))
      documentInstance.save()

      redirect ( action:'list' )
    }

    def download () {
      def documentInstance = Document.get(params.id)
      response.setContentType("APPLICATION/OCTET-STREAM")
      response.setHeader("Content-Disposition", "Attachment;Filename=\"${documentInstance.filename}\"")
      // def file = new File(documentInstance.fullPath)
      // response.outputStream << file.bytes
      // def file = new File(documentInstance.fullPath)
      // def fileInputStream = new fileInputStream(file)
      // def outputStream = response.getOutputStream()
      // byte[] buffer = new byte[4096];
      // int len;
      // while ((len = fileInputStream.read(buffer)) > 0) {
      //     outputStream.write(buffer, 0, len);
      // }
      // outputStream.flush()
      // outputStream.close()
      // fileInputStream.close()
      render "hello world"
    }


}
