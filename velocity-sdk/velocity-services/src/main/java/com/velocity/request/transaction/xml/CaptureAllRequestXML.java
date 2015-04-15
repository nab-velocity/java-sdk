package com.velocity.request.transaction.xml;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.velocity.exceptions.VelocityException;
import com.velocity.exceptions.VelocityIllegalArgumentException;
import com.velocity.exceptions.VelocityNotFoundException;
import com.velocity.exceptions.VelocityRestInvokeException;
import com.velocity.model.request.CaptureAll;

/**
 * This class creates the request XML for CaptureAll transaction
 * 
 * @author Vimal Kumar
 * @date April 14, 2015
 */
public class CaptureAllRequestXML {

    private static final Logger LOG = Logger.getLogger(CaptureAllRequestXML.class);

    /**
     * This method generates the XML for CaptureAll request.
     * 
     * @param captureAllTransaction - holds the value for the type CaptureAllTransaction
     * @param appProfileId - Application profile Id for transaction initiation.
     * @param merchantProfileId - Merchant profile Id for transaction initiation.
     * @return String - Returns the instance of the type String.
     * @throws VelocityException - Exception for Velocity transaction
     * @throws VelocityIllegalArgumentException - Thrown when illegal argument supplied.
     * @throws VelocityNotFoundException - Thrown when some resource not found.
     * @throws VelocityRestInvokeException - Thrown when exception occurs at invoking REST API .
     */
    public String captureAllXML(CaptureAll captureAllTransaction, String appProfileId, String merchantProfileId) throws VelocityException, VelocityIllegalArgumentException, VelocityNotFoundException, VelocityRestInvokeException {
        /* Creating the instance for DOM parsing */
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder;
        try{
            docBuilder = docFactory.newDocumentBuilder();
            // root elements
            Document doc = docBuilder.newDocument();
            // create CaptureAll root segment
            createCaptureAll(doc, captureAllTransaction, appProfileId, merchantProfileId);
            return VelocityXMLUtil.prettyPrint(doc);
        }catch (ParserConfigurationException ex){
            LOG.error("Error Occurred :", ex);
        }catch (Exception ex){
            LOG.error("Error Occurred :", ex);
        }
        return null;
    }
    /**
     * This method creates the root elements, attributes and segments with text using the
     * VelocityXMLUtil class.
     */
    public static void createCaptureAll(Document doc, CaptureAll captureAllTransaction, String appProfileId, String merchantProfileId) {
        Element captureAllElement = VelocityXMLUtil.rootElement(doc, "CaptureAll");
        VelocityXMLUtil.addAttr(doc, captureAllElement, "xmlns:i", "http://www.w3.org/2001/XMLSchema-instance");
        VelocityXMLUtil.addAttr(doc, captureAllElement, "xmlns", "http://schemas.ipcommerce.com/CWS/v2.0/Transactions/Rest");
        VelocityXMLUtil.addAttr(doc, captureAllElement, "i:type", "CaptureAll");
        VelocityXMLUtil.generateSegmentsWithText(captureAllElement, doc, "ApplicationProfileId", appProfileId);
        Element batchIdsElement = VelocityXMLUtil.generateXMLElement(captureAllElement, doc, "BatchIds");
        VelocityXMLUtil.addAttr(doc, batchIdsElement, "xmlns:d2p1", "http://schemas.microsoft.com/2003/10/Serialization/Arrays");
        VelocityXMLUtil.addAttr(doc, batchIdsElement, "i:nil", String.valueOf(captureAllTransaction.getBatchIds().isNillable()));
        VelocityXMLUtil.addTextToElement(batchIdsElement, doc, captureAllTransaction.getBatchIds().getValue());
        createDifferenceData(captureAllElement, doc, captureAllTransaction);
        VelocityXMLUtil.generateSegmentsWithText(captureAllElement, doc, "MerchantProfileId", merchantProfileId);
    }
    private static void createDifferenceData(Element element, Document doc, CaptureAll captureAllTransaction) {
        Element differenceDataElement = VelocityXMLUtil.generateXMLElement(element, doc, "DifferenceData");
        VelocityXMLUtil.addAttr(doc, differenceDataElement, "xmlns:ns1", "http://schemas.ipcommerce.com/CWS/v2.0/Transactions/Bankcard");
        VelocityXMLUtil.addAttr(doc, differenceDataElement, "i:nil", String.valueOf(captureAllTransaction.getDifferenceData().isNillable()));
        VelocityXMLUtil.addTextToElement(differenceDataElement, doc, captureAllTransaction.getDifferenceData().getValue());
    }
}
